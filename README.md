# kafka 学习

### 下载地址

https://kafka.apache.org/documentation/#quickstart

### 启动 kafka

    $ bin/zookeeper-server-start.sh config/zookeeper.properties 
    $ bin/kafka-server-start.sh config/server.properties

#

    本质上kafka只支持Topic.每个consumer属于一个consumer group;反过来说,每个group中可以有多个consumer.发送到Topic的消息,只会被订阅此Topic的每个group中的一个consumer消费.
        如果所有的consumer都具有相同的group,这种情况和queue模式很像;消息将会在consumers之间负载均衡.
        如果所有的consumer都具有不同的group,那这就是"发布-订阅";消息将会广播给所有的消费者.
        在kafka中,一个partition中的消息只会被group中的一个consumer消费;每个group中consumer消息消费互相独立;我们可以认为一个group是一个"订阅"者,一个Topic中的每个partions,只会被一个"订阅者"中的一个consumer消费,不过一个consumer可以消费多个partitions中的消息.
        kafka只能保证一个partition中的消息被某个consumer消费时,消息是顺序的.事实上,从Topic角度来说,消息仍不是有序的.

   
#
    kafka的消费模型

        消息由生产者发送到kafka集群后，会被消费者消费。一般来说我们的消费模型有两种:推送模型(push)和拉取模型(pull)
        基于推送模型的消息系统，由消息代理记录消费状态。消息代理将消息推送到消费者后，标记这条消息为已经被消费，但是这种方式无法很好地保证消费的处理语义。比如当我们把已经把消息发送给消费者之后，由于消费进程挂掉或者由于网络原因没有收到这条消息，如果我们在消费代理将其标记为已消费，这个消息就永久丢失了。如果我们利用生产者收到消息后回复这种方法，消息代理需要记录消费状态，这种不可取。如果采用push，消息消费的速率就完全由消费代理控制，一旦消费者发生阻塞，就会出现问题。
        Kafka采取拉取模型(poll)，由自己控制消费速度，以及消费的进度，消费者可以按照任意的偏移量进行消费。比如消费者可以消费已经消费过的消息进行重新处理，或者消费最近的消息等等。

 



NS;vk6VLER5WT。OirpoFIFeI8Z5DVNwdHW

kubectl exec -it -n provider xjp-ccf5c644c-gkcjc bash
apt-get update
apt-get install telnet

    host: azrzayjancnidataprod.redis.cache.chinacloudapi.cn
    port: 6380





