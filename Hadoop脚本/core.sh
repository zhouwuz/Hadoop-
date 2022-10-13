HOSTNAME=$1
IP1=$2
IP2=$3:
#me: config-core-site.sh
## author: hyy
## date: 2021-5-21
## desc: config the file core-site.xml

## the path of core-site.xml，之前的配置文件中已经配置hadoop_dir为全局变量，所以此处可以应用
file_path=$HADOOP_HOME/etc/hadoop/core-site.xml

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

        <!-- 配置的namenode的内部通信地址  -->
        <property>
                <name>fs.defaultFS</name>
                <value>hdfs://$HOSTNAME:9000</value>
        </property>

        <!-- hadoop的内部的数据或者元数据真是的存放路径 -->
        <property>
                <name>hadoop.tmp.dir</name>
                <value>$HADOOP_HOME/hdpdata</value>
        </property>
</configuration>
EOF
scp -P 9999 /usr/hadoop/hadoop-2.6.0/etc/hadoop/core-site.xml root@$2:/usr/hadoop/hadoop-2.6.0/etc/hadoop/
scp -P 9999 /usr/hadoop/hadoop-2.6.0/etc/hadoop/core-site.xml root@$3:/usr/hadoop/hadoop-2.6.0/etc/hadoop/
echo "config core-site.xml finished..."


