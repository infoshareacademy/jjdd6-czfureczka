package com.infoshareacademy.jjdd6.czfureczka.database;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "ADMINISTRATOR")
public class Administrator {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "e_mail")
    @NotNull
    @Email
    private String email;

    @Column(name = "add_administrator")
    @NotNull
    private boolean addNewAdministrator;

    @Column(name = "delet_Administrator")
    @NotNull
    private boolean deleteAdministrator;

    public Administrator(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAddNewAdministrator() {
        return addNewAdministrator;
    }

    public void setAddNewAdministrator(boolean addNewAdministrator) {
        this.addNewAdministrator = addNewAdministrator;
    }

    public boolean isDeleteAdministrator() {
        return deleteAdministrator;
    }

    public void setDeleteAdministrator(boolean deleteAdministrator) {
        this.deleteAdministrator = deleteAdministrator;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Administrator{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", addNewAdministrator=").append(addNewAdministrator);
        sb.append(", deleteAdministrator=").append(deleteAdministrator);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return addNewAdministrator == that.addNewAdministrator &&
                deleteAdministrator == that.deleteAdministrator &&
                Objects.equals(id, that.id) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, addNewAdministrator, deleteAdministrator);
    }
}
