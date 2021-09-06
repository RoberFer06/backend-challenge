package com.skytel.challenge.login_backend.resources;

import com.skytel.challenge.login_backend.resources.dtos.RegisterDTO;

public class GenerateTokenCase {

    RegisterDTO user;

    public GenerateTokenCase(RegisterDTO user){
        this.user = user;
    }

    public  String generateToken() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String ch: user.getFirstName().toLowerCase().split("")) {
            if (ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")) {
                stringBuilder.append(ch);
            }
        }
        stringBuilder.append(user.getLastName().charAt(0));
        stringBuilder.append(user.getLastName().charAt(user.getLastName().length() -1));

        for (String nm : this.user.getPhone().split("")){
            if (Integer.parseInt(nm) % 2 == 0) {
                stringBuilder.append(nm);
            }
        }

        return stringBuilder.toString();
    }
}
