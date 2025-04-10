package ir.rahyabcp.collector.dataaccess.local.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "NODE_INFO", schema = "DATA_COLLECTOR")
public class NodeInfoEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "nodeInfoSequenceGenerator", sequenceName = "NODE_INFO_SEQ", allocationSize = 1, schema = "DATA_COLLECTOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nodeInfoSequenceGenerator")
    private int id;

    @Column(name = "CONNECTION_PROTOCOL", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConnectionProtocol connectionProtocol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConnectionProtocol getConnectionProtocol() {
        return connectionProtocol;
    }

    public void setConnectionProtocol(ConnectionProtocol connectionProtocol) {
        this.connectionProtocol = connectionProtocol;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (!(o instanceof NodeInfoEntity that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
