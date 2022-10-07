# network-tools

某个网址可以在postman和浏览器中正常访问，但是无法在Java程序中访问。

直接使用curl命令在Terminal（Mac）和PowerShell（Windows）也是可以正常访问的。

在go和node中也无法正常访问。看起来使用编程的方式都无法访问？

真的是这样吗？这个项目即用来测试这种情况。

# 测试结果

各种方式测试结果如下：


| 访问方式                  | 结果                                                                                                                           | 说明                                                             |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------- |
| native-java-Socket        |                                                                                                                                | TODO                                                             |
| native-java-URLConnection | 可以正常访问，不带Header（header中cookie信息）的情况下<br />第一次访问会失败，重复请求可以成功。带上header后可以正常访问成功。 |                                                                  |
| okhttp                    | 可以正常访问，小概率会失败，失败重试可以访问成功。                                                                             |                                                                  |
| jsoup                     | 可以正常访问，小概率会失败，失败重试可以访问成功。                                                                             |                                                                  |
| httpclient                | 无法正常访问。                                                                                                                 |                                                                  |
| hutools                   |                                                                                                                                | TODO                                                             |
| netty-httpclient          |                                                                                                                                | TODO                                                             |
| native-java-command       | 可以正常访问，一定成功。                                                                                                       | 使用java.lang.Process执行系统的curl命令。                        |
| java-curl                 | 可以正常访问，一定成功。                                                                                                       | 使用[java-curl](https://github.com/rockswang/java-curl)库。      |
| jPowerShell               |                                                                                                                                | TODO[jPowerShell](https://github.com/profesorfalken/jPowerShell) |

> 注意：以上方式使用JDK8环境进行测试，JDK11环境下测试失败。

TODO

1.输出打印。

2.curl命令转输入。（或者使用postman代码生成）。

3.代码转移到测试类中，可以一键执行，方便观察测试结果。

4.测试类类名使用对应的模块名称标识，便于观察。

### 参考

[native-java-network](./native-java-network/README.MD)

### 资源

[curl转换为代码](https://github.com/curlconverter/curlconverter) [在线地址](https://curlconverter.com/)
