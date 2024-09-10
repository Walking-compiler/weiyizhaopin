import threading
from concurrent import futures
import grpc
import time
import requests

from myprotobuf import Demo_pb2_grpc
from GrpcServer import grpcServer

#from person_information_BIORE import personpredict
'''
NACOS_PORT=os.environ["NACOS_PORT"]
NACOS_IP=os.environ["NACOS_IP"]
SERVICE_IP = os.environ["SERVICE_IP"]
SERVICE_PORT = os.environ["SERVICE_PORT"]
'''
SERVICE_IP = '192.168.177.106'
SERVICE_PORT = 20002
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
        'serviceName': 'python-service',
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
        "serviceName": "python-service",
        'ip': SERVICE_IP,
        'port': SERVICE_PORT
    }
    while True:
        response = requests.put(
            "{NACOS_URL}/{NACOS_HEARTBEATS_URL}".format(NACOS_URL=NACOS_URL, NACOS_HEARTBEATS_URL=NACOS_HEARTBEATS_URL),
            params=params)
        print("已注册服务，执行心跳服务，续期服务响应状态： {status_code}".format(status_code=response.status_code))
        time.sleep(HEARTBEATS_TIME)





def server():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=100))
    Demo_pb2_grpc.add_GrpcServiceServicer_to_server(grpcServer(), server)
    server.add_insecure_port(f'[::]:{SERVICE_PORT}')
    server.start()
    server.wait_for_termination()



if __name__ == '__main__':

    service_register()
    # 服务检测
    t1 = threading.Thread(target=service_beat)
    t1.start()
    t2 = threading.Thread(target=server)
    t2.start()
    t1.join()
    t2.join()