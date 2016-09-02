package goeuro;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"_id", "name", "type", "latitude", "longitude"})
public class City {
    @JsonProperty("_id")
    private final Integer id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("type")
    private final String type;
    @JsonUnwrapped
    @JsonProperty("geo_position")
    private final GeoPosition geoPosition;

    @JsonCreator
    public City(@JsonProperty("_id") Integer id,
                @JsonProperty("name") String name,
                @JsonProperty("type") String type,
                @JsonProperty("geo_position") GeoPosition geoPosition) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.geoPosition = geoPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City location = (City) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        if (name != null ? !name.equals(location.name) : location.name != null) return false;
        if (type != null ? !type.equals(location.type) : location.type != null) return false;
        return geoPosition != null ? geoPosition.equals(location.geoPosition) : location.geoPosition == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", geoPosition=" + geoPosition +
                '}';
    }
}
