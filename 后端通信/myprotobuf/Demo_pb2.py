# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: myprotobuf/Demo.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x15myprotobuf/Demo.proto\"5\n\rJobAndCompany\x12\x13\n\x0b\x63ompanyName\x18\x01 \x01(\t\x12\x0f\n\x07jobName\x18\x02 \x01(\t\"f\n\x11\x44ifferenceRequest\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0e\n\x06userid\x18\x02 \x01(\x03\x12\x0f\n\x07message\x18\x03 \x01(\t\x12\"\n\njobAndName\x18\x04 \x01(\x0b\x32\x0e.JobAndCompany\"Q\n\x12\x44ifferenceResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0e\n\x06userid\x18\x02 \x01(\x03\x12\x0f\n\x07message\x18\x03 \x01(\t\x12\x0c\n\x04\x64\x61ta\x18\x04 \x01(\t\"G\n\x16GetRecommendJobRequest\x12\x0e\n\x06userId\x18\x01 \x01(\x03\x12\x0c\n\x04\x63ode\x18\x02 \x01(\x05\x12\x0f\n\x07message\x18\x03 \x01(\t\"\xd7\x02\n\x03Job\x12\r\n\x05jobId\x18\x01 \x01(\x03\x12\x0f\n\x07jobName\x18\x02 \x01(\t\x12\x0f\n\x07jobDesc\x18\x03 \x01(\t\x12\x0f\n\x07jobType\x18\x04 \x01(\t\x12\x11\n\tjobSalary\x18\x05 \x01(\t\x12\x13\n\x0bjobLocation\x18\x06 \x01(\t\x12\x15\n\rjobExperience\x18\x07 \x01(\t\x12\x14\n\x0cjobEducation\x18\x08 \x01(\t\x12\x10\n\x08jobSkill\x18\t \x01(\t\x12\x11\n\tcompanyId\x18\n \x01(\x03\x12\x12\n\njobCompany\x18\x0b \x01(\t\x12\x16\n\x0ejobCompanyDesc\x18\x0c \x01(\t\x12\x1a\n\x12jobCompanyLocation\x18\r \x01(\t\x12\x17\n\x0fjobCompanyScale\x18\x0e \x01(\t\x12\x1a\n\x12jobCompanyIndustry\x18\x0f \x01(\t\x12\x17\n\x0fjobMatchPercent\x18\x10 \x01(\t\"\\\n\x17GetRecommendJobResponse\x12\x12\n\x04jobs\x18\x01 \x03(\x0b\x32\x04.Job\x12\x0e\n\x06userId\x18\x02 \x01(\x03\x12\x0c\n\x04\x63ode\x18\x03 \x01(\x05\x12\x0f\n\x07message\x18\x04 \x01(\t\"\x84\x03\n\x08UserInfo\x12\x0e\n\x06userId\x18\x01 \x01(\x03\x12\x0e\n\x06skills\x18\x02 \x01(\t\x12\x10\n\x08projects\x18\x03 \x01(\t\x12\x1c\n\x14internshipExperience\x18\x04 \x01(\t\x12\x17\n\x0f\x64\x65siredPosition\x18\x05 \x01(\t\x12\x11\n\teducation\x18\x06 \x01(\t\x12\x16\n\x0eworkExperience\x18\x07 \x01(\t\x12\x15\n\rdesiredSalary\x18\x08 \x01(\t\x12\x1a\n\x12locationPreference\x18\t \x01(\t\x12\x13\n\x0b\x63\x65rtificate\x18\n \x01(\t\x12\x1b\n\x13professionalSummary\x18\x0b \x01(\t\x12\x17\n\x0flinkedinProfile\x18\x0c \x01(\t\x12\x1b\n\x13\x65\x64ucationExperience\x18\r \x01(\t\x12\r\n\x05\x65mail\x18\x0e \x01(\t\x12\r\n\x05phone\x18\x0f \x01(\t\x12\x0b\n\x03sex\x18\x10 \x01(\t\x12\x10\n\x08\x62irthday\x18\x11 \x01(\t\x12\x0c\n\x04name\x18\x12 \x01(\t\"E\n\x14\x45xtractResumeRequest\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\x12\x0e\n\x06userId\x18\x03 \x01(\x03\"c\n\x15\x45xtractResumeResponse\x12\x0c\n\x04\x63ode\x18\x01 \x01(\x05\x12\x0f\n\x07message\x18\x02 \x01(\t\x12\x0e\n\x06userId\x18\x03 \x01(\x03\x12\x1b\n\x08userInfo\x18\x04 \x01(\x0b\x32\t.UserInfo2\xd3\x01\n\x0bGrpcService\x12:\n\rgetDifference\x12\x12.DifferenceRequest\x1a\x13.DifferenceResponse\"\x00\x12\x46\n\x0fGetRecommendJob\x12\x17.GetRecommendJobRequest\x1a\x18.GetRecommendJobResponse\"\x00\x12@\n\rExtractResume\x12\x15.ExtractResumeRequest\x1a\x16.ExtractResumeResponse\"\x00\x42(\n\x14\x63om.glimmer.protobufB\x10grpcServiceProtob\x06proto3')



_JOBANDCOMPANY = DESCRIPTOR.message_types_by_name['JobAndCompany']
_DIFFERENCEREQUEST = DESCRIPTOR.message_types_by_name['DifferenceRequest']
_DIFFERENCERESPONSE = DESCRIPTOR.message_types_by_name['DifferenceResponse']
_GETRECOMMENDJOBREQUEST = DESCRIPTOR.message_types_by_name['GetRecommendJobRequest']
_JOB = DESCRIPTOR.message_types_by_name['Job']
_GETRECOMMENDJOBRESPONSE = DESCRIPTOR.message_types_by_name['GetRecommendJobResponse']
_USERINFO = DESCRIPTOR.message_types_by_name['UserInfo']
_EXTRACTRESUMEREQUEST = DESCRIPTOR.message_types_by_name['ExtractResumeRequest']
_EXTRACTRESUMERESPONSE = DESCRIPTOR.message_types_by_name['ExtractResumeResponse']
JobAndCompany = _reflection.GeneratedProtocolMessageType('JobAndCompany', (_message.Message,), {
  'DESCRIPTOR' : _JOBANDCOMPANY,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:JobAndCompany)
  })
_sym_db.RegisterMessage(JobAndCompany)

DifferenceRequest = _reflection.GeneratedProtocolMessageType('DifferenceRequest', (_message.Message,), {
  'DESCRIPTOR' : _DIFFERENCEREQUEST,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:DifferenceRequest)
  })
_sym_db.RegisterMessage(DifferenceRequest)

DifferenceResponse = _reflection.GeneratedProtocolMessageType('DifferenceResponse', (_message.Message,), {
  'DESCRIPTOR' : _DIFFERENCERESPONSE,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:DifferenceResponse)
  })
_sym_db.RegisterMessage(DifferenceResponse)

GetRecommendJobRequest = _reflection.GeneratedProtocolMessageType('GetRecommendJobRequest', (_message.Message,), {
  'DESCRIPTOR' : _GETRECOMMENDJOBREQUEST,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:GetRecommendJobRequest)
  })
_sym_db.RegisterMessage(GetRecommendJobRequest)

Job = _reflection.GeneratedProtocolMessageType('Job', (_message.Message,), {
  'DESCRIPTOR' : _JOB,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:Job)
  })
_sym_db.RegisterMessage(Job)

GetRecommendJobResponse = _reflection.GeneratedProtocolMessageType('GetRecommendJobResponse', (_message.Message,), {
  'DESCRIPTOR' : _GETRECOMMENDJOBRESPONSE,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:GetRecommendJobResponse)
  })
_sym_db.RegisterMessage(GetRecommendJobResponse)

UserInfo = _reflection.GeneratedProtocolMessageType('UserInfo', (_message.Message,), {
  'DESCRIPTOR' : _USERINFO,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:UserInfo)
  })
_sym_db.RegisterMessage(UserInfo)

ExtractResumeRequest = _reflection.GeneratedProtocolMessageType('ExtractResumeRequest', (_message.Message,), {
  'DESCRIPTOR' : _EXTRACTRESUMEREQUEST,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:ExtractResumeRequest)
  })
_sym_db.RegisterMessage(ExtractResumeRequest)

ExtractResumeResponse = _reflection.GeneratedProtocolMessageType('ExtractResumeResponse', (_message.Message,), {
  'DESCRIPTOR' : _EXTRACTRESUMERESPONSE,
  '__module__' : 'myprotobuf.Demo_pb2'
  # @@protoc_insertion_point(class_scope:ExtractResumeResponse)
  })
_sym_db.RegisterMessage(ExtractResumeResponse)

_GRPCSERVICE = DESCRIPTOR.services_by_name['GrpcService']
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\024com.glimmer.protobufB\020grpcServiceProto'
  _JOBANDCOMPANY._serialized_start=25
  _JOBANDCOMPANY._serialized_end=78
  _DIFFERENCEREQUEST._serialized_start=80
  _DIFFERENCEREQUEST._serialized_end=182
  _DIFFERENCERESPONSE._serialized_start=184
  _DIFFERENCERESPONSE._serialized_end=265
  _GETRECOMMENDJOBREQUEST._serialized_start=267
  _GETRECOMMENDJOBREQUEST._serialized_end=338
  _JOB._serialized_start=341
  _JOB._serialized_end=684
  _GETRECOMMENDJOBRESPONSE._serialized_start=686
  _GETRECOMMENDJOBRESPONSE._serialized_end=778
  _USERINFO._serialized_start=781
  _USERINFO._serialized_end=1169
  _EXTRACTRESUMEREQUEST._serialized_start=1171
  _EXTRACTRESUMEREQUEST._serialized_end=1240
  _EXTRACTRESUMERESPONSE._serialized_start=1242
  _EXTRACTRESUMERESPONSE._serialized_end=1341
  _GRPCSERVICE._serialized_start=1344
  _GRPCSERVICE._serialized_end=1555
# @@protoc_insertion_point(module_scope)
