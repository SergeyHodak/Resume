package resume.visitor.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitor")
@Data
public class VisitorModel {
    @Id
    @Column(name = "IP")
    private String IP;

    @Column(name = "reaction")
    private Boolean reaction = false;
}
