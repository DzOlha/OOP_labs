# Lab 2 description

## Tasks
1. Create an XML file and its corresponding XSD schema.
#### When developing XSD, use simple and complex types, enumerations, templates and limit values, it is mandatory to use attributes and the ID type
2. Generate (create) a Java class that matches the given description.
3. Create a Java application to parse an XML document and initialize a collection of objects with information from an XML file. 
#### For parsing use SAX, DOM and StAX parsers. Use the Comparator interface to sort objects.
4. Validate an XML document using XSD.
5. Define a method that transforms the developed XML document into the document specified in each job.
#### Avoid copy-pasting code.
### All code must be covered by unit tests.

## Option #1: Greenhouse.
The plants contained in the greenhouse have the following characteristics:
* Name - the name of the plant.
* Soil - soil for planting, which can be of the following types: podzolic, chernozem, sod-podzolic.
* Origin - the place of origin of the plant.
* Visual parameters (there must be several) – external parameters: stem color, leaf color, average plant size.
* Growing tips (should be several) - preferred growing conditions: temperature (in degrees), lighting (light-requiring or not), watering (ml per week).
* Propagation - reproduction: leaves, cuttings or seeds.
 
* #### Name the root element Flower.