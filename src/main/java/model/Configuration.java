package model;

import jakarta.persistence.*;

@SequenceGenerator(name = "tb_game_configuration_seq", allocationSize = 1)
@Entity
@Table(name = "tb_game_configuration")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_game_configuration_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "initial_coins")
    private Long initialCoins;

    @Column(name = "score_per_hit")
    private Long scorePerHit;

    @Column(name = "level")
    private String level;

    public Configuration() {
    }

    public Configuration(Long id, Long initialCoins, Long scorePerHit, String level) {
        this.id = id;
        this.initialCoins = initialCoins;
        this.scorePerHit = scorePerHit;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInitialCoins() {
        return initialCoins;
    }

    public void setInitialCoins(Long initialCoins) {
        this.initialCoins = initialCoins;
    }

    public Long getScorePerHit() {
        return scorePerHit;
    }

    public void setScorePerHit(Long scorePerHit) {
        this.scorePerHit = scorePerHit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Configuration {" +
                "id = " + id +
                ", initial coins = " + initialCoins +
                ", score per hit = " + scorePerHit +
                ", level = '" + level + '\'' +
                '}';
    }

    public static final class Builder {
        private Configuration configuration;

        private Builder() {
            configuration = new Configuration();
        }

        public static Builder aConfiguration() {
            return new Builder();
        }

        public Builder id(Long id) {
            configuration.setId(id);
            return this;
        }

        public Builder initialCoins(Long initialCoins) {
            configuration.setInitialCoins(initialCoins);
            return this;
        }

        public Builder scorePerHit(Long scorePerHit) {
            configuration.setScorePerHit(scorePerHit);
            return this;
        }

        public Builder level(String level) {
            configuration.setLevel(level);
            return this;
        }

        public Configuration build() {
            return configuration;
        }

    }

}
