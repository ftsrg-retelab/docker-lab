FROM ubuntu:xenial
RUN apt-get update

RUN export DEBIAN_FRONTEND=noninteractive && \
apt-get -q -y install mysql-server mysql-client &&\
/etc/init.d/mysql start && \
mysqladmin -u root password retelab

ADD mysql-listen.cnf /etc/mysql/mysql.conf.d/zlisten.cnf
ADD golf.sql /tmp/

RUN /etc/init.d/mysql start && \
    mysql -h localhost -u root -pretelab -e "GRANT ALL PRIVILEGES ON *.* TO root@'%' IDENTIFIED BY 'retelab'" && \
    mysql -h localhost -u root -pretelab < /tmp/golf.sql

CMD mysqld
