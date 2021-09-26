#使用jdk8作为基础镜像
FROM java:8
#指定作者
MAINTAINER Lee
#暴漏容器的8080端口 -P 是用
#EXPOSE 8080
#将复制target文件中的jar为容器中的test.jar，相当于拷贝到容器中取了个别名
ADD target/*.jar /app.jar
#创建一个新的容器并在新的容器中运行命令
RUN bash -c 'touch /app.jar'
#设置时区 根据情况看是否需要
#ENV TZ=PRC
#RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
#相当于在容器中用cmd命令执行jar包  指定外部配置文件
ENTRYPOINT ["java","-jar","/app.jar"]