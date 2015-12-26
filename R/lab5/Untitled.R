dat <- read.table ("dat.txt")
cl<-kmeans(dat,2)
table(cl$cluster)
cl$centers

plot(dat,col=ifelse(cl$cluster==1,"blue","green"))
legend("topleft",legend=c("1","2"),fill=c("blue","green"))

plot(dat,pch=ifelse(cl$cluster==1,1,2))
legend("topleft",legend=c("1","2"),pch=c(1,2))

cl<-kmeans(dat,3)
table(cl$cluster)
cl$centers

plot(dat,col=ifelse(cl$cluster==1,"blue",ifelse(cl$cluster==2,"green","red")))
legend("topleft",legend=c("1","2","3"),fill=c("blue","green","red"))

plot(dat,pch=ifelse(cl$cluster==1,1, ifelse(cl$cluster==2,2,3)))
legend("topleft",legend=c("1","2", "3"),pch=c(1,2,3))

