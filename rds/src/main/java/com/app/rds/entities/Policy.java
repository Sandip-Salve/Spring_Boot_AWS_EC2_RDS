package com.app.rds.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="policy_id")
    private Long policyId;

    @Column(name = "policy_name", length = 25)
    private String policyName;

    @Column(name = "amount")
    private Double policyAmount;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Double getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(Double policyAmount) {
        this.policyAmount = policyAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyName='" + policyName + '\'' +
                ", policyAmount=" + policyAmount +
                '}';
    }
}
