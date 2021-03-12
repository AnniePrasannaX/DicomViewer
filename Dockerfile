FROM ubuntu:latest
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
COPY dicomparser_1.0-1.deb .
RUN apt install ./dicomparser_1.0-1.deb
COPY test.DCM .
ENV LD_LIBRARY_PATH="/usr/lib/x86_64-linux-gnu/:/usr/local/jisnalib/"
