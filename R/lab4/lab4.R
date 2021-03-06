f<-as.data.frame(c(1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010))
f[,2]<-as.data.frame(c(71,71,72,73,74,74,75,77,77,78,81,82,84,86,86,86))
colnames(f)<-c("Год", "Объем продукции")
f
mediumlevel<-mean(f[,2])
mediumlevel
result<-numeric()
for(i in 1:length(f[,2])) {
  if(f[i,2]>mediumlevel) result<-c(result, 1)
  if(f[i,2]<mediumlevel) result<-c(result, 0)
}
y<-f[,2]
result
numberofseries<-1
var<-result[1]
for(i in 2:length(result)) {
  if(result[i]!=var) {
    numberofseries<-numberofseries+1
    var<-result[i]
  }
}
numberofseries
leftpart<-as.integer((length(result)+1)/2-1.96*sqrt(length(result)-1)/2)
leftpart
rightpart<-as.integer((length(result)+1)/2+1.96*sqrt(length(result)-1)/2)
rightpart
if(leftpart<=numberofseries & numberofseries<=rightpart) {
  answer<-"Нет"
} else {
  answer<-"Есть"
}
answer
smoothed<-numeric()
smoothed<-c(smoothed, (5*y[1]+2*y[2]-y[3])/6)
for(i in 2:(length(f[,1])-1)) {
  smoothed<-c(smoothed, (y[i-1]+y[i]+y[i+1])/3)
}
smoothed<-c(smoothed, (5*y[length(f[,1])-1]+2*y[length(f[,1])-2]-y[length(f[,1])-3])/6)
smoothed
t<-numeric()
var<-((-1)*as.integer(length(y)/2))
as.integer(length(y)/2)
for(i in 1:length(y)) {
  t<-c(t, var)
  var<-var+1
  if(var==0) var<-var+1
}
f[,3]<-t
f[,4]<-t*t
f[,5]<-f[,2]*f[,3]
colnames(f)<-c("x", "y", "t", "t^2", "y*t")
f
a0<-sum(f[,2]/length(f[,2]))
a1<-sum(f[,5])/sum(f[,4])
equation<-paste("y(t)=", a0, "+", a1, "t")
equation
analyticsmoothed<-numeric()
for(i in 1:length(f[,2])) {
  analyticsmoothed<-c(analyticsmoothed, a0+a1*(i-as.integer(length(y)/2)))
}
prognoz<-a0+a1*10
prognoz
fun1<-function(x) f[,2]
fun2<-function(x) smoothed
fun3<-function(x) analyticsmoothed
matplot(f[,1],cbind(fun1(x),fun2(x), fun3(x)),type="l",col=c("blue","red", "green"), xlab="Год", ylab="Объем продукции", main="График")
legend(x="topright", y=0.92, legend=c("Исходный", "Сглаженный", "Аналитически выравненный"), lty=c(1,1,1), lwd=c(2.5,2.5,2.5), col=c("blue", "red", "green"))