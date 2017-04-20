/*
 * Copyright (C) 2017 Danny Monroy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.fs.socialcareapp;

import java.sql.Date;

/**
 * VisitItem This class models the data needed for a first approach in the application.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class VisitItem {

    private String title;
    private String name;
    private String middle_name;
    private String surname;
    private String area;
    private String start_time;
    private String end_time;
    private String address;
    private String postcode;
    private String general_information;
    private String keycode;
    private String level_vulnerability;


    public VisitItem(String title, String name,String middle_name, String surname, String area, String start_time, String end_time, String address, String postcode, String general_information, String keycode, String level_vulnerability ) {
        this.title = title;
        this.name = name;
        this.middle_name = middle_name;
        this.surname = surname;
        this.area = area;
        this.start_time = start_time;
        this.end_time = end_time;
        this.address = address;
        this.postcode = postcode;
        this.general_information = general_information;
        this.keycode = keycode;
        this.level_vulnerability =  level_vulnerability;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {return surname;}

    public String getArea() {
        return area;
    }

    public String getStartTime() {
        return start_time;
    }

    public String getMiddleName() { return middle_name; }

    public String getEndTime() { return end_time;  }

    public String getAddress() { return address; }

    public String getPostcode() { return postcode; }

    public String getGeneralInformation() { return general_information; }

    public String getKeycode() { return keycode; }

    public String getLevelVulnerability() { return level_vulnerability; }

}
