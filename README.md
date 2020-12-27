# avaj-launcher

Implementation of a simple Java program according to a given class diagram written in UML.

## TO COMPILE

`
$ find * -name "*.java" | tr "\n" " " > sources.txt
`

## TO RUN

`
$ java io.github.ilkou.simulator.Simulator scenario.txt
`

## Docker (Java 7)

`
$ docker pull williamyeh/java7
$ docker run -it --rm -v ~/Desktop/avaj-launcher:/avaj-launcher williamyeh/java7 bash
`


