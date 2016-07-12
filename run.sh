#!/bin/sh

exec java -Xmx$JAVA_XMX -jar /opt/zenquizz-web/bin/zenquizz-web.jar "$@"