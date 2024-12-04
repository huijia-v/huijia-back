# 贝尔实验室 Spring 官方推荐镜像 JDK下载地址 https://bell-sw.com/pages/downloads/
FROM bellsoft/liberica-openjdk-debian:17.0.11-cds
#FROM bellsoft/liberica-openjdk-debian:21.0.3-cds
#FROM findepi/graalvm:java17-native

LABEL maintainer="huijia"

RUN mkdir -p /huijia/server/logs \
    /huijia/server/temp \
    /huijia/skywalking/agent

WORKDIR /huijia/server

ENV SERVER_PORT=8080 LANG=C.UTF-8 LC_ALL=C.UTF-8 JAVA_OPTS=""

EXPOSE ${SERVER_PORT}

ADD ./target/huijia-admin.jar ./app.jar

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Dserver.port=${SERVER_PORT} \
           # 应用名称 如果想区分集群节点监控 改成不同的名称即可
           #-Dskywalking.agent.service_name=huijia-server \
           #-javaagent:/huijia/skywalking/agent/skywalking-agent.jar \
           -XX:+HeapDumpOnOutOfMemoryError -XX:+UseZGC ${JAVA_OPTS} \
           -jar app.jar

