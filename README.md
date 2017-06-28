# Social Care Application

## General

![Social Care Application](http://imgur.com/80v8RtA)

This project was done to complete my final year in BSc Computing at Birkbeck. It consists of two parts:

* Android Application
* Web Application

This repository is the code for the Android Application. To look at the web application please click [here](https://github.com/dannymonroy/SocialCarePanel).

## Motivation

After working some years in the social care industry in the United Kingdom I got to see first hand the inefficient use of resources to solve that I started programming this application in the Spring of 2017.

The motivation was to help with the communication deficiencies in the industry.

To do this the system is composed of two parts an Android application and a web application.

## Android Part

The Android application allows a care worker to be able to check and update the clients she needs to visit. It will allow her to get more detailed information (provided by the manager) as well as directions and report information.

To do this a login page was created for authentication. A responsive *RecyclerView* for the list and schedule and lastly, a network process using *Volley* to query the database.

Lastly, intents are used to access more client information, for example, Google maps and reporting using Gmail.












