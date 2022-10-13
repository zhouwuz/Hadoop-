HOSTNAME=h3m2203
IP1=10.7.120.75
IP2=10.7.120.131
/root/dadadaa/installhadoop.sh $IP1 $IP2
/root/dadadaa/core.sh $HOSTNAME $IP1 $IP2
/root/dadadaa/env.sh $IP1 $IP2
/root/dadadaa/hdfs-site.sh $HOSTNAME $IP1 $IP2
/root/dadadaa/mapred.sh $HOSTNAME $IP1 $IP2
/root/dadadaa/yarn.sh $HOSTNAME $IP1 $IP2
cd /usr/hadoop/hadoop-2.6.0 
sbin/start-all.sh

