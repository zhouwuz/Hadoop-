HOSTNAME=$1
IP1=$2
IP2=$3

file_path=$HADOOP_HOME/etc/hadoop/mapred-site.xml.template

# config the content
cat << EOF > ${file_path}
<configuration>

<property>
<name>mapreduce.framework.name</name>
<value>yarn</value>
<final>true</final>
</property>

<property>
<name>mapreduce.jobtracker.http.address</name>
<value>$HOSTNAME:50030</value>
</property>

<property>
<name>mapreduce.jobhistory.address</name>
<value>$HOSTNAME:10020</value>
</property>

<property>
<name>mapreduce.jobhistory.webapp.addess</name>
<value>$HOSTNAME:19888</value>
</property>

<property>
<name>mapred.job.tracker</name>
<value>http://$HOSTNAME:9001</value>
</property>

</configuration>

EOF

scp -P 9999 /usr/hadoop/hadoop-2.6.0/etc/hadoop/mapred-site.xml.template root@$2:/usr/hadoop/hadoop-2.6.0/etc/hadoop/
scp -P 9999 /usr/hadoop/hadoop-2.6.0/etc/hadoop/mapred-site.xml.template root@$3:/usr/hadoop/hadoop-2.6.0/etc/hadoop/
echo "config mapred-site.xml finished..."
