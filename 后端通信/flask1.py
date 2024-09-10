import json

from flask import Flask,jsonify,request

import os
app = Flask(__name__)
import grpc
import os
import threading
from concurrent import futures
import grpc
import time
import requests

#from person_information_BIORE import personpredict
'''
NACOS_PORT=os.environ["NACOS_PORT"]
NACOS_IP=os.environ["NACOS_IP"]
SERVICE_IP = os.environ["SERVICE_IP"]
SERVICE_PORT = os.environ["SERVICE_PORT"]
'''
SERVICE_IP = '192.168.177.106'
SERVICE_PORT = 20003
NACOS_IP = '192.168.254.1'
NACOS_PORT = 55078
# 心跳时间
HEARTBEATS_TIME = 5
# Nacos地址
NACOS_URL = f'http://{NACOS_IP}:{NACOS_PORT}/nacos'
# 服务注册路由
NACOR_REGISTER_URL = 'v1/ns/instance'
# 心跳检测路由
NACOS_HEARTBEATS_URL = 'v1/ns/instance/beat'

# Nacos服务注册
def service_register():
    """
    Nacos服务注册的接口有以下参数：
    ip          服务实例IP
    port        服务实例port
    namespaceId 命名空间ID
    weight      权重
    enabled     是否上线
    healthy     是否健康
    metadata    扩展信息
    clusterName 集群名
    serviceName 服务名
    groupName   分组名
    ephemeral   是否临时实例
    :return:
    """
    # 返回参数
    result = {
        "code": 200,
        "message": "success"
    }
    # 构造请求参数
    params = {
        'serviceName': 'rest-service',
        'ip': SERVICE_IP,
        'port': SERVICE_PORT
    }
    response = requests.post(
        "{NACOS_URL}/{NACOR_REGISTER_URL}".format(NACOS_URL=NACOS_URL, NACOR_REGISTER_URL=NACOR_REGISTER_URL),
        params=params)
    if response.status_code != 200:
        result["code"] = response.status_code
        result["message"] = "服务注册Nacos失败，失败原因：{error_message}".format(error_message=response.text)
        return result
    if response.text != 'ok':
        result["code"] = 500
        result["message"] = "服务注册Nacos失败，失败原因：{error_message}".format(error_message=response.text)
        return result
    return result

def service_beat():
    """
    服务心跳，默认是5s一次
    :return:
    nacos的服务心跳接口有以下参数
    serviceName 服务名
    ip          服务实例IP
    port        服务实例PORT
    namespaceId 命名空间ID
    groupName   分组名
    ephemeral   是否临时实例
    beat        实例心跳内容
    """
    # 构造请求参数
    params = {
        "serviceName": "rest-service",
        'ip': SERVICE_IP,
        'port': SERVICE_PORT
    }
    while True:
        response = requests.put(
            "{NACOS_URL}/{NACOS_HEARTBEATS_URL}".format(NACOS_URL=NACOS_URL, NACOS_HEARTBEATS_URL=NACOS_HEARTBEATS_URL),
            params=params)
        print("已注册服务，执行心跳服务，续期服务响应状态： {status_code}".format(status_code=response.status_code))
        time.sleep(HEARTBEATS_TIME)



UPLOAD_FOLDER = 'uploads/'
@app.route('/uploadResume',methods=['POST'])
def post_resume():
    user_id = request.form.get('userID')
    resume_file = request.files.get('file')
    failed_msg = {
        'code':400,
        'msg':'failed uplaod'
    }
    failed_json = json.dumps(failed_msg)
    if user_id is None or resume_file is None:
        return failed_json

    user_folder = os.path.join(UPLOAD_FOLDER, user_id)
    os.makedirs(user_folder, exist_ok=True)

    file_path = os.path.join(user_folder, resume_file.filename)
    resume_file.save(file_path)
    success_msg = {
        'code':200,
        'msg':'success uplaod'
    }
    success_json = json.dumps(success_msg)

    return success_json

if __name__ == '__main__':

    service_register()
    # 服务检测
    t1 = threading.Thread(target=service_beat)
    t1.start()
    t2 = threading.Thread(target=app.run,args=['0.0.0.0',SERVICE_PORT])
    t2.start()
    t1.join()
    #app.run(host='0.0.0.0')