FROM python:3.8

COPY ./src/weiyi/ /opt/src
WORKDIR /opt/src

RUN pip install pip -U
RUN pip config set global.index-url https://pypi.tuna.tsinghua.edu.cn/simple
RUN pip install torch==2.1.2 torchvision==0.16.2 torchaudio==2.1.2
RUN pip install -r requirements.txt
CMD ["python", "./grpc-config/greeter_server.py"]