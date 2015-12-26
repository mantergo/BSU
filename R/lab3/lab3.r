t <- read.table ("input.txt")

plot (t, main = "Correlation")

disp <- var (t[,1])
deviat <- sqrt (disp)
aver <- mean (t[,1])

gr1 <- subset (t[,1], ((aver - deviat) <= t[,1]) & (t[,1] <= (aver + deviat)))
gr2 <- subset (t[,1], ((aver - 2 * deviat) <= t[,1]) & (t[,1] <= (aver + 2 * deviat)))
gr3 <- subset (t[,1], ((aver - 3 * deviat) <= t[,1]) & (t[,1] <= (aver + 3 * deviat)))

part2 <- matrix (0, 3, 3)

part2[1:3,1] <- c (length (gr1), length (gr2), length(gr3))
part2[1:3,2] <- part2[1:3,1]/length (t[,1]) * 100
part2[1:3,3] <- c (68.3, 95.4, 99.7)

range <- max (t[,1]) - min (t[,1])
k <- 1 + floor (log (length (t[,1]), 2))
h <- range / k

sa <- sort (t[,1])

part3 <- matrix (0, k, 3)

for (i in 0:(k-1)) {
    l <- sa[1] + i * h
    r <- sa[1] + (i + 1) * h
    gr <- subset (sa, l <= sa & (sa < r | i == k - 1 & sa <= r))
    part3[i + 1, 1:3] <- c(length (gr), sum (gr), mean (gr))
}

v <- length (t[,1]) - 2
coefcor <- cor (t[,1], t[,2])
T <- abs (coefcor) * sqrt (v / (1 - coefcor ^2))

coefcor
T
lm (t[,2]~t[,1])

part2
part3
b<- -(sum(t[,1]*t[,2]))/sum(t[,1]*t[,1])
b
a<- mean(t[,2])-b*mean(t[,1])
a

lines(t[,1],abs(a + b*t[,1]))

