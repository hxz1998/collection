# 镜像构建jdk版本，一定要大于等于当前编译的版本
FROM openjdk:11

MAINTAINER cherry

# 修改工作目录
WORKDIR /

# 设置字符集，防止乱码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

# 拷贝jar包到工作目录下
COPY k8s-helloworld.jar k8s-helloworld.jar

# 设定时区
ENV TZ=Asia/Shanghai

# 容器启动点
ENTRYPOINT ["java", "-jar", "./k8s-helloworld.jar"]

# 容器对外暴露8080端口
EXPOSE 8080