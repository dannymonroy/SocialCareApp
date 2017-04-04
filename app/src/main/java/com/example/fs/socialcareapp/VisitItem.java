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

/**
 * VisitItem This class models the data needed for a first approach in the application.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class VisitItem {

    private String title;
    private String fullName;
    private String area;
        private String startDate;

    public VisitItem(String title, String fullName, String area, String startDate) {
        this.title = title;
        this.fullName = fullName;
        this.area = area;
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public String getFullName() {
        return fullName;
    }

    public String getArea() {
        return area;
    }

    public String getStartTime() {
        return startDate;
    }
}
