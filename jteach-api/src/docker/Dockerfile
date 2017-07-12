FROM java:openjdk-8-jdk

COPY package.tgz /tmp

RUN mkdir /usr/src/myapp && tar -xvf /tmp/package.tgz -C /usr/src/myapp
RUN rm /tmp/package.tgz

WORKDIR /usr/src/myapp

RUN ls -rl

EXPOSE 8081
CMD ["./startup.sh"]

