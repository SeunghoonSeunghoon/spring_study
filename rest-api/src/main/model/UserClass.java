package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserClass {
    private String name;

    private String number;

    private String mail;

    private boolean isKorean;
}
