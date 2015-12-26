rm(list=ls(all=TRUE))
dat<-read.table(file="f.txt",sep=",")


d<-as.numeric(dat)
#View(d)
sr_zn<-mean(d)    #среднее значение
disp<-var(d)  #дисперсия
kv_o<-sd(d)    #квадратическое отклонение
moda<-which.max(table(d)) #мода
med<-median(d)  #медиана



#коэффициент ассиметрии
a<-table(d)
a
zn<-sort(unique(d))
zn
sr_znach<-mean(d)
sr_znach
n<-length(d)
n
disp<-var(d)
disp
koeff_asimm<-sum((zn-sr_znach)^3*a)/(n*disp^3)
koeff_asimm
koeff_ex<-sum((zn-sr_znach)^4*a)/(n*disp^4)-3
koeff_ex

m<-10
p<-(m/length(d))
p
b<-sort(d)
b

#Усеченное среднее
usech_sr<-mean(d,p,TRUE)
usech_sr

#Коэффициент вариации
koef_var<-disp/sr_znach*100
koef_var

#Линейное отклонение
lin_otkl<-sum(abs(d-sr_znach))/n
lin_otkl

