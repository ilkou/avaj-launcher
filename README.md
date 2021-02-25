# avaj-launcher

Implementation of a simple Java program according to a given class diagram written in UML.

## TO COMPILE

`
$ find * -name "*.java" > sources.txt
`

`
$ javac @sources.txt
`

## TO RUN

`
$ java -classpath src io.github.ilkou.avaj.simulator.Simulator scenario.txt
`

## Docker (Java 7)

`
$ docker pull williamyeh/java7
`

`
$ docker run -it --rm -v ~/Desktop/avaj-launcher:/avaj-launcher williamyeh/java7 bash
`

## UML Class Diagram

![alt text](https://github.com/ilkou/avaj-launcher/blob/main/avaj_uml.png)
