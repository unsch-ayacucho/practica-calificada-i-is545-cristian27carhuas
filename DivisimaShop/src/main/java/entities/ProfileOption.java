package pe.edu.unsch.entities;
// Generated 16/07/2019 01:54:40 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProfileOption generated by hbm2java
 */
@Entity
@Table(name = "profile_option", catalog = "divisimabd")
public class ProfileOption implements java.io.Serializable {

	private Integer idprofileoption;
	private Option option;
	private Profile profile;
	private Byte status;

	public ProfileOption() {
	}

	public ProfileOption(Option option, Profile profile) {
		this.option = option;
		this.profile = profile;
	}

	public ProfileOption(Option option, Profile profile, Byte status) {
		this.option = option;
		this.profile = profile;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idprofileoption", unique = true, nullable = false)
	public Integer getIdprofileoption() {
		return this.idprofileoption;
	}

	public void setIdprofileoption(Integer idprofileoption) {
		this.idprofileoption = idprofileoption;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idoption", nullable = false)
	public Option getOption() {
		return this.option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprofile", nullable = false)
	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Column(name = "status")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}
