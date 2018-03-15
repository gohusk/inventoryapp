package com.inventory.item.model;

import javax.persistence.*;

@Entity
@Table(name = "inventory_type")
public class InventoryType {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "is_active")
    private boolean isActive;

    protected InventoryType() {
    }

    public InventoryType(String description, boolean isActive) {
        this.description = description;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, description='%s']",
                id, description);
    }
}