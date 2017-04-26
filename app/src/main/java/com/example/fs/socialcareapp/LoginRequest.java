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

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * LoginRequest deals with making a request using Volley. To do that we extend the class StringRequest from volley, create a constructor with the parameters we want and add a listener for the click.
 * Then we override the method getParameters to pass to put the parameters sent in a HashMap. This class is linked with closely with LoginActivity.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class LoginRequest extends StringRequest {
    private static final String LOGIN = "https://socialcareapp.000webhostapp.com/login.php";
    private Map<String, String> parameters;

    public LoginRequest(String carer_id, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN, listener, null);
        parameters = new HashMap<>();
        parameters.put("carer_id", carer_id);
        parameters.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}