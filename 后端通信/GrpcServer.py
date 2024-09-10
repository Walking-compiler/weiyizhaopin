import glob
import myprotobuf.Demo_pb2_grpc as Demo_pb2_grpc
import myprotobuf.Demo_pb2 as Demo_pb2
from person_information_BIORE import personpredict
from person_company_job_desire import personpredictpropro
from bert_prediction import bert_predict,Job_recommend
import os
from person_information_BIORE import init_model
from person_information_BIORE import person_information


def get_first_pdf_or_docx_filename(directory):
    # 搜索 .pdf 文件
    pdf_files = glob.glob(os.path.join(directory, '*.pdf'))
    if pdf_files:
        return os.path.basename(pdf_files[0])  # 返回第一个找到的 .pdf 文件名

    # 如果没有找到 .pdf 文件，搜索 .docx 文件
    docx_files = glob.glob(os.path.join(directory, '*.docx'))
    if docx_files:
        return os.path.basename(docx_files[0])  # 返回第一个找到的 .docx 文件名

    # 如果没有找到任何文件，返回 None
    return None


class grpcServer(Demo_pb2_grpc.GrpcServiceServicer):
    def __init__(self):
        self.model, self.device = init_model()

    def ExtractResume(self, request, context):
        path = request.userId
        user = path
        path = './uploads/' + str(path) + '/' + get_first_pdf_or_docx_filename('./uploads/' + str(path))
        matchphone, matchemail, matches, matcheslocation,matchesworkexperiece,matchesproject,matchesname,matchesgender,matchesbirthday,JN,JR, PS, education = personpredict(person_path=path, model=self.model,
                                                                           device=self.device)
        userInfo1 = Demo_pb2.UserInfo()
        userInfo1.professionalSummary = ','.join(PS)
        userInfo1.skills = ','.join(JN)
        userInfo1.educationExperience = ','.join(matches)
        userInfo1.education = education
        userInfo1.phone = matchphone
        userInfo1.email = matchemail
        userInfo1.locationPreference=matcheslocation
        userInfo1.certificate=','.join(JR)
        userInfo1.workExperience=','.join(matchesworkexperiece)
        userInfo1.projects=matchesproject[0]
        userInfo1.name=matchesname
        userInfo1.birthday=matchesbirthday
        userInfo1.sex=matchesgender

        return Demo_pb2.ExtractResumeResponse(code=200, userId=user, userInfo=userInfo1, message='简历分析成功！！！')

    def GetRecommendJob(self, request, context):
        path = request.userId
        user = path
        path = './uploads/' + str(path) + '/' + get_first_pdf_or_docx_filename('./uploads/' + str(path))
        job1,education = bert_predict(person_path=path)
        job_recommend=job1
        jobs = []
        #job2=pass
        #job_recommend=Job_recommend(job1,job2)
        for i in job_recommend:
            job = Demo_pb2.Job()
            job.jobName = i
            job.jobEducation=education
            jobs.append(job)
        # print(jobs)
        # job1=Demo_pb2.Job
        # jobs.extend()
        response = Demo_pb2.GetRecommendJobResponse(code=200, jobs=jobs, userId=user,
                                                    message='职位推荐成功！！！')
        print(response)
        return response

    def getDifference(self, request, context):
        path = request.userid
        user = path
        path = './uploads/' + str(path)
        company_desire = request.jobAndName.companyName
        job_desire = request.jobAndName.jobName
        print(company_desire)
        print(job_desire)
        data = personpredictpropro(person_path=path, company_desire=company_desire, job_desire=job_desire)
        print(data)
        return Demo_pb2.DifferenceResponse(code=200, userid=user, data=data, message='职位差距分析成功！！！')
