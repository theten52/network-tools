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
| java-curl                 |                                                                                                                                | TODO[java-curl](https://github.com/rockswang/java-curl)          |
| jPowerShell               |                                                                                                                                | TODO[jPowerShell](https://github.com/profesorfalken/jPowerShell) |

参考：

[native-java-network](./native-java-network/README.MD)
