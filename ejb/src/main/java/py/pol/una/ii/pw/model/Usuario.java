package py.pol.una.ii.pw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Usuario on 02/08/2017.
 */
@Entity
@XmlRootElement
@Table(name = "usuario")
public class Usuario implements Serializable{
    
	private static final long serialVersionUID = 1661689693653129956L;
	
	private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    private Roles roles;
    private Boolean superuser;
    private Boolean staff;
    private Date ultimoLogin;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String apellido, String email, String username,
                   String password, Boolean superuser, Boolean staff, Date ultimoLogin) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.password = password;
        this.superuser = superuser;
        this.staff = staff;
        this.ultimoLogin = ultimoLogin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_usuario_seq")
    @SequenceGenerator(name = "id_usuario_seq", sequenceName = "id_usuario_seq", allocationSize = 1, initialValue = 1)
    @Column(name="id_usuario")
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password")
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="superuser")
    public Boolean getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Boolean superuser) {
        this.superuser = superuser;
    }

    @Column(name="staff")
    public Boolean getStaff() {
        return staff;
    }

    public void setStaff(Boolean staff) {
        this.staff = staff;
    }
    @Column(name="ultimo_login")
    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_rol")
    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
