# thrift Demo
java server and python client <br>
from https://www.baeldung.com/apache-thrift
## 生成 java 代码
thrift -r -out src/main/java --gen java src/main/thrift-sources/service.thrift

## 生成 python 代码
thrift -r -out src/main/python --gen java src/main/thrift-sources/service.thrift
### 安装 python 依赖
pip install thrift==0.13.0
<br>
可能需要更新 pip: python -m pip install --upgrade pip

#### python 客户端 demo
```python
from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

from service import CrossPlatformService


def main():
    # Make socket
    transport = TSocket.TSocket('localhost', 9090)

    # Buffering is critical. Raw sockets are very slow
    transport = TTransport.TBufferedTransport(transport)

    # Wrap in a protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)

    # Create a client to use the protocol encoder
    client = CrossPlatformService.Client(protocol)

    # Connect!
    transport.open()

    client.ping()
    print('ping()')
    print(client.get(1))

    # Close!
    transport.close()

if __name__ == '__main__':
    try:
        main()
    except Thrift.TException as tx:
      print('%s' % tx.message)
```