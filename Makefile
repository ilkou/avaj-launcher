
NAME = compile
EXECUTE = execute

SOURCES = sources.txt
SIMULATION = simulation.txt

all: $(NAME)

$(NAME):
	find * -name "*.java" > $(SOURCES)
	javac @$(SOURCES)

$(EXECUTE):
	@java -classpath src io.github.ilkou.avaj.simulator.Simulator scenario.txt
	@cat $(SIMULATION)

clean: 
	find . -type f -path "./src/*/*" -name "*.class" -exec rm -f {} \;
	rm -rf $(SOURCES)
	rm -rf $(SIMULATION)

fclean: clean

re: fclean all
