package com.votingly.votingly-app.controller.api.dto.user;

public class PlatformAdminDto extends UserDto {
    public PlatformAdminDto() {
    }

    public PlatformAdminDto(String firstName, String lastName, String email, long id) {
        super(id, firstName, lastName, email);
    }
}
