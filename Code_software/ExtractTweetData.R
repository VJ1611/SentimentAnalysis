install.packages("twitteR")
require(twitteR)
library(ROAuth)
library(twitteR)
load("my_oauth.Rdata")
searchTwitter("#liveittobelieveit")

install.packages(c("devtools", "rjson", "bit64", "httr"))
install.packages("curl")
install_github("geoffjentry/twitteR")
install.packages('base64enc')
install.packages("httpuv")

library(devtools)
library(rjson)
library(httr)
library(bit64)

library(twitteR)
setup_twitter_oauth("eQtdh0UiDScLkHSYXFdDTLmOe", "PQPrjdZXahqWNjRoZ28I2nW6CmQPVPW2QTYtkCSu6xanR4ldbQ","2582309766-j107MDIHLm9ExZhjJyvUGSY7DoKqmWB94S9bXTs","5caf7Z4ZmhCtVCbkvyCuugC5X7xvAh9EmJXcSnqUMUbkG")
#list2 <- searchTwitter('apartment hunting', geocode='40.7361,-73.9901,200mi',  n=5000, retryOnRateLimit=1)
list <- searchTwitter("#CostaRica",since='2015-12-11',until='2015-12-13',n=100)
list2<- twListToDF(list);
library(xlsx); #load the package
write.xlsx(x = list2, file = "CostaRica.xlsx",
           sheetName = "TestSheet", row.names = FALSE)
