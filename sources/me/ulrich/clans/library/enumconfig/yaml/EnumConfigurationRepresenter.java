package me.ulrich.clans.library.enumconfig.yaml;

import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.representer.Representer;
import me.ulrich.clans.library.enumconfig.library.representer.SafeRepresenter;
import me.ulrich.clans.library.enumconfig.yaml.file.interfaces.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/EnumConfigurationRepresenter.class */
public class EnumConfigurationRepresenter extends Representer {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/yaml/EnumConfigurationRepresenter$RepresentConfigurationSection.class */
    private class RepresentConfigurationSection extends SafeRepresenter.RepresentMap {
        private RepresentConfigurationSection() {
            super();
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.SafeRepresenter.RepresentMap, me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return super.representData(((ConfigurationSection) obj).getValues(false));
        }
    }

    public EnumConfigurationRepresenter() {
        super(new DumperOptions());
        this.multiRepresenters.put(ConfigurationSection.class, new RepresentConfigurationSection());
    }
}
