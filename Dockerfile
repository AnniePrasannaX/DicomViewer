FROM ubuntu:latest

# Install OpenJDK-8
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;

# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME
EXPOSE 8443
RUN apt update
ARG DEBIAN_FRONTEND=noninteractive
RUN apt install gcc wget -y
RUN apt install build-essential -y
RUN wget https://github.com/Kitware/CMake/releases/download/v3.17.2/cmake-3.17.2-Linux-x86_64.sh \
      -q -O /tmp/cmake-install.sh \
      && chmod u+x /tmp/cmake-install.sh \
      && mkdir /usr/bin/cmake \
      && /tmp/cmake-install.sh --skip-license --prefix=/usr/bin/cmake \
      && rm /tmp/cmake-install.sh

ENV PATH="/usr/bin/cmake/bin:${PATH}"
#RUN apt install cmake -y
RUN apt install libdcmtk2-dev -y
RUN wget https://repo.mysql.com/apt/ubuntu/pool/mysql-8.0/m/mysql-community/mysql-community-client-plugins_8.0.23-1ubuntu20.04_amd64.deb
RUN apt install ./mysql-community-client-plugins_8.0.23-1ubuntu20.04_amd64.deb
RUN wget https://repo.mysql.com/apt/ubuntu/pool/mysql-tools/m/mysql-connector-c++/libmysqlcppconn8-2_8.0.23-1ubuntu20.04_amd64.deb
RUN apt install ./libmysqlcppconn8-2_8.0.23-1ubuntu20.04_amd64.deb
RUN apt install libmysqlcppconn-dev mysql-server -y
RUN apt-get install -y libjsoncpp-dev
COPY dicomparser_1.0-1.deb .
RUN apt install ./dicomparser_1.0-1.deb
COPY 0003.DCM .
COPY test.DCM .
ENV LD_LIBRARY_PATH="/usr/lib/x86_64-linux-gnu/:/usr/local/jisnalib/"

ADD DicomViewer.jar DicomViewer.jar
ENTRYPOINT ["java","-jar","/DicomViewer.jar"]

