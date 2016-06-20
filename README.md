# XY Inc

The purpose of this software is to allow our clients to find places of interest, so they could easily find out what's near them or some desired location.

This software has an O(n) complexity for searching the places of interest near a desired location, there are better algorithms but they demand a time and a complexity that we could not afford right now, for the future we intend to implement something based on KD-Tree for spherical spaces, some biographies use the VP-Tree terminology.

## How to build it
Clone the repository and on the directory use the following command: 
> $./gradlew build

## How to use it
On the repository directory use the following command:
> $.gradlew bootRun

Then use a HTTP Client to use the following system services:

###### To add a point of interest you should send a POST to the following URL informing the desired values:
> http://localhost:8080/addpointofinterest?name=**test.01**&x=**0**&y=**1**

###### To see all the points of interest registred in the system you should send a GET to the following URL:
> http://localhost:8080/listpointsofinterest

###### To see all the points closer than a distance **maxDistance** from a point **P(X,Y)** you should send a GET to the following URL:
> http://localhost:8080/listpointsofinterestclosertopoint?x=**2**&y=**2**&maxDistance=**0**
