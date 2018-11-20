package functional_programming_devoxx;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


class User {
    private String firstName;
    private String lastName;
    private String username;
    private LocalDate deactivationDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(LocalDate deactivationDate) {
        this.deactivationDate = deactivationDate;
    }
}

class UserDto {
    private String fullName;
    private String username;
    private boolean active;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

interface UserRepo {
    List<User> findAll();
}

class UserFacade {


    private UserRepo userRepo;

    private UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFullName(user.getFirstName() + " " + user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setActive(user.getDeactivationDate() == null);
        return userDto;
    }

    private List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }
}
