#! /bin/bash

## the path of hdfs-site.xml
HOSTNAME=$1
IP1=$2
IP2=$3

file_path=$HADOOP_HOME/etc/hadoop/hdfs-site.xml

## config the content
cat << EOF > ${file_path}
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<!--
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License. See accompanying LICENSE file.
-->

<!-- Put site-specific property overrides in this file. -->

<configuration>
<property>
<name>dfs.replication</name>
<value>2</value>
</property>
<property>
<name>dfs.namenode.name.dir</name>
<value>file://$HADOOP_HOME/dfs/name</value>
</property>
<property>
<name>dfs.datanode.data.dir</name>
<value>file://$HADOOP_HOME/dfs/data</value>
</property>
<property>
<name>dfs.nameservices</name>
<value>$HOSTNAME</value>
</property>
<property>
<name>dfs.namenode.secondary.http-address</name>
<value>$HOSTNAME:50090</value>
</property>
<property>
<name>dfs.webhdfs.enabled</name>
<value>true</value>
</property>
</configuration>

EOF


scp -P 9999 /usr/hadoop/hadoop-2.6.0/etc/hadoop/hdfs-site.xml root@$2:/usr/hadoop/hadoop-2.6.0/etc/hadoop/
scp -P 9999 /usr/hadoop/hadoop-2.6.0/etc/hadoop/hdfs-site.xml root@$3:/usr/hadoop/hadoop-2.6.0/etc/hadoop/

echo "config hdfs-site.xml finished..."

