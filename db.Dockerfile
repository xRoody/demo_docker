FROM postgres

ENV POSTGRES_USER=noost
ENV POSTGRES_PASSWORD=134652

COPY init.sql /docker-entrypoint-initdb.d/

