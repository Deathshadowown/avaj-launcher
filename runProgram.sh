rm -f simulator/vehicles/*.class
rm -f simulator/*.class
rm -f weather/*.class
rm -f simulation.txt
javac simulator/Simulator.java
java simulator.Simulator scenario.txt