package se.lexicon.springdatajpaassignmnet.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(nullable = false, length = 80)
    private String instructions;
    @OneToOne(mappedBy = "recipeInstruction")
    private Recipe recipe;
    public RecipeInstruction() {
    }

    public RecipeInstruction(String instructions) {
        this();
        this.instructions = instructions;
    }

    public RecipeInstruction(String id, String instructions) {
        this.id = id;
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(id, that.id) && Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id='" + id + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
