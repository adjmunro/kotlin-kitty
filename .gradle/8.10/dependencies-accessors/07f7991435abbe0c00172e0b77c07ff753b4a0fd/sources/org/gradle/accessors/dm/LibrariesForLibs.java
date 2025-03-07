package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ChromiumLibraryAccessors laccForChromiumLibraryAccessors = new ChromiumLibraryAccessors(owner);
    private final Junit5LibraryAccessors laccForJunit5LibraryAccessors = new Junit5LibraryAccessors(owner);
    private final KotestLibraryAccessors laccForKotestLibraryAccessors = new KotestLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final MockkLibraryAccessors laccForMockkLibraryAccessors = new MockkLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>chromium</b>
     */
    public ChromiumLibraryAccessors getChromium() {
        return laccForChromiumLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit5</b>
     */
    public Junit5LibraryAccessors getJunit5() {
        return laccForJunit5LibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotest</b>
     */
    public KotestLibraryAccessors getKotest() {
        return laccForKotestLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlin</b>
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Group of libraries at <b>kotlinx</b>
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>mockk</b>
     */
    public MockkLibraryAccessors getMockk() {
        return laccForMockkLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ChromiumLibraryAccessors extends SubDependencyFactory {

        public ChromiumLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jcef</b> with <b>me.friwi:jcefmaven</b> coordinates and
         * with version reference <b>chromium.jcef</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJcef() {
            return create("chromium.jcef");
        }

    }

    public static class Junit5LibraryAccessors extends SubDependencyFactory {

        public Junit5LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.junit.jupiter:junit-jupiter-api</b> coordinates and
         * with version reference <b>junit5</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("junit5.api");
        }

        /**
         * Dependency provider for <b>params</b> with <b>org.junit.jupiter:junit-jupiter-params</b> coordinates and
         * with version reference <b>junit5</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getParams() {
            return create("junit5.params");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>org.junit.jupiter:junit-jupiter-engine</b> coordinates and
         * with version reference <b>junit5</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("junit5.runtime");
        }

    }

    public static class KotestLibraryAccessors extends SubDependencyFactory {

        public KotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>assertions</b> with <b>io.kotest:kotest-assertions-core</b> coordinates and
         * with version reference <b>kotest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAssertions() {
            return create("kotest.assertions");
        }

        /**
         * Dependency provider for <b>property</b> with <b>io.kotest:kotest-property</b> coordinates and
         * with version reference <b>kotest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProperty() {
            return create("kotest.property");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinGradleLibraryAccessors laccForKotlinGradleLibraryAccessors = new KotlinGradleLibraryAccessors(owner);
        private final KotlinMetadataLibraryAccessors laccForKotlinMetadataLibraryAccessors = new KotlinMetadataLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bom</b> with <b>org.jetbrains.kotlin:kotlin-bom</b> coordinates and
         * with version reference <b>kotlin.language</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBom() {
            return create("kotlin.bom");
        }

        /**
         * Dependency provider for <b>reflect</b> with <b>org.jetbrains.kotlin:kotlin-reflect</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getReflect() {
            return create("kotlin.reflect");
        }

        /**
         * Dependency provider for <b>stdlib</b> with <b>org.jetbrains.kotlin:kotlin-stdlib</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getStdlib() {
            return create("kotlin.stdlib");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.jetbrains.kotlin:kotlin-test</b> coordinates and
         * with version reference <b>kotlin.language</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("kotlin.test");
        }

        /**
         * Group of libraries at <b>kotlin.gradle</b>
         */
        public KotlinGradleLibraryAccessors getGradle() {
            return laccForKotlinGradleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlin.metadata</b>
         */
        public KotlinMetadataLibraryAccessors getMetadata() {
            return laccForKotlinMetadataLibraryAccessors;
        }

    }

    public static class KotlinGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>plugin</b> with <b>org.jetbrains.kotlin:kotlin-gradle-plugin</b> coordinates and
         * with version reference <b>kotlin.language</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPlugin() {
            return create("kotlin.gradle.plugin");
        }

    }

    public static class KotlinMetadataLibraryAccessors extends SubDependencyFactory {

        public KotlinMetadataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jvm</b> with <b>org.jetbrains.kotlin:kotlin-metadata-jvm</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJvm() {
            return create("kotlin.metadata.jvm");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);
        private final KotlinxSerializationLibraryAccessors laccForKotlinxSerializationLibraryAccessors = new KotlinxSerializationLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>atomicfu</b> with <b>org.jetbrains.kotlinx:atomicfu</b> coordinates and
         * with version reference <b>kotlinx.atomicfu</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAtomicfu() {
            return create("kotlinx.atomicfu");
        }

        /**
         * Dependency provider for <b>datetime</b> with <b>org.jetbrains.kotlinx:kotlinx-datetime</b> coordinates and
         * with version reference <b>kotlinx.datetime</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDatetime() {
            return create("kotlinx.datetime");
        }

        /**
         * Dependency provider for <b>io</b> with <b>org.jetbrains.kotlinx:kotlinx-io-core</b> coordinates and
         * with version reference <b>kotlinx.io</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getIo() {
            return create("kotlinx.io");
        }

        /**
         * Group of libraries at <b>kotlinx.coroutines</b>
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() {
            return laccForKotlinxCoroutinesLibraryAccessors;
        }

        /**
         * Group of libraries at <b>kotlinx.serialization</b>
         */
        public KotlinxSerializationLibraryAccessors getSerialization() {
            return laccForKotlinxSerializationLibraryAccessors;
        }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-core</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("kotlinx.coroutines.core");
        }

        /**
         * Dependency provider for <b>debug</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-debug</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDebug() {
            return create("kotlinx.coroutines.debug");
        }

        /**
         * Dependency provider for <b>guava</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-guava</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGuava() {
            return create("kotlinx.coroutines.guava");
        }

        /**
         * Dependency provider for <b>jvm</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJvm() {
            return create("kotlinx.coroutines.jvm");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-test</b> coordinates and
         * with version reference <b>kotlinx.coroutines</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("kotlinx.coroutines.test");
        }

    }

    public static class KotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public KotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>json</b> with <b>org.jetbrains.kotlinx:kotlinx-serialization-json</b> coordinates and
         * with version reference <b>kotlinx.serialization.json</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJson() {
            return create("kotlinx.serialization.json");
        }

    }

    public static class MockkLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public MockkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mockk</b> with <b>io.mockk:mockk</b> coordinates and
         * with version reference <b>mockk</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("mockk");
        }

        /**
         * Dependency provider for <b>android</b> with <b>io.mockk:mockk-android</b> coordinates and
         * with version reference <b>mockk</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("mockk.android");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ChromiumVersionAccessors vaccForChromiumVersionAccessors = new ChromiumVersionAccessors(providers, config);
        private final ComposeVersionAccessors vaccForComposeVersionAccessors = new ComposeVersionAccessors(providers, config);
        private final JavaVersionAccessors vaccForJavaVersionAccessors = new JavaVersionAccessors(providers, config);
        private final Junit5VersionAccessors vaccForJunit5VersionAccessors = new Junit5VersionAccessors(providers, config);
        private final KotlinVersionAccessors vaccForKotlinVersionAccessors = new KotlinVersionAccessors(providers, config);
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotest</b> with value <b>5.9.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotest() { return getVersion("kotest"); }

        /**
         * Version alias <b>mockk</b> with value <b>1.13.16</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMockk() { return getVersion("mockk"); }

        /**
         * Group of versions at <b>versions.chromium</b>
         */
        public ChromiumVersionAccessors getChromium() {
            return vaccForChromiumVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.compose</b>
         */
        public ComposeVersionAccessors getCompose() {
            return vaccForComposeVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.java</b>
         */
        public JavaVersionAccessors getJava() {
            return vaccForJavaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.junit5</b>
         */
        public Junit5VersionAccessors getJunit5() {
            return vaccForJunit5VersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotlin</b>
         */
        public KotlinVersionAccessors getKotlin() {
            return vaccForKotlinVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotlinx</b>
         */
        public KotlinxVersionAccessors getKotlinx() {
            return vaccForKotlinxVersionAccessors;
        }

    }

    public static class ChromiumVersionAccessors extends VersionFactory  {

        public ChromiumVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>chromium.jcef</b> with value <b>132.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJcef() { return getVersion("chromium.jcef"); }

    }

    public static class ComposeVersionAccessors extends VersionFactory  {

        public ComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>compose.multiplatform</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMultiplatform() { return getVersion("compose.multiplatform"); }

    }

    public static class JavaVersionAccessors extends VersionFactory  {

        public JavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>java.language</b> with value <b>22</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLanguage() { return getVersion("java.language"); }

    }

    public static class Junit5VersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public Junit5VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit5</b> with value <b>5.11.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("junit5"); }

        /**
         * Version alias <b>junit5.plugin</b> with value <b>1.11.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPlugin() { return getVersion("junit5.plugin"); }

    }

    public static class KotlinVersionAccessors extends VersionFactory  {

        private final KotlinSymbolVersionAccessors vaccForKotlinSymbolVersionAccessors = new KotlinSymbolVersionAccessors(providers, config);
        public KotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlin.language</b> with value <b>2.1.10</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLanguage() { return getVersion("kotlin.language"); }

        /**
         * Group of versions at <b>versions.kotlin.symbol</b>
         */
        public KotlinSymbolVersionAccessors getSymbol() {
            return vaccForKotlinSymbolVersionAccessors;
        }

    }

    public static class KotlinSymbolVersionAccessors extends VersionFactory  {

        public KotlinSymbolVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlin.symbol.processing</b> with value <b>2.1.10-1.0.30</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getProcessing() { return getVersion("kotlin.symbol.processing"); }

    }

    public static class KotlinxVersionAccessors extends VersionFactory  {

        private final KotlinxSerializationVersionAccessors vaccForKotlinxSerializationVersionAccessors = new KotlinxSerializationVersionAccessors(providers, config);
        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlinx.atomicfu</b> with value <b>0.27.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAtomicfu() { return getVersion("kotlinx.atomicfu"); }

        /**
         * Version alias <b>kotlinx.coroutines</b> with value <b>1.10.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoroutines() { return getVersion("kotlinx.coroutines"); }

        /**
         * Version alias <b>kotlinx.datetime</b> with value <b>0.6.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDatetime() { return getVersion("kotlinx.datetime"); }

        /**
         * Version alias <b>kotlinx.io</b> with value <b>0.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getIo() { return getVersion("kotlinx.io"); }

        /**
         * Group of versions at <b>versions.kotlinx.serialization</b>
         */
        public KotlinxSerializationVersionAccessors getSerialization() {
            return vaccForKotlinxSerializationVersionAccessors;
        }

    }

    public static class KotlinxSerializationVersionAccessors extends VersionFactory  {

        public KotlinxSerializationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlinx.serialization.json</b> with value <b>1.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJson() { return getVersion("kotlinx.serialization.json"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final JetbrainsPluginAccessors paccForJetbrainsPluginAccessors = new JetbrainsPluginAccessors(providers, config);
        private final Junit5PluginAccessors paccForJunit5PluginAccessors = new Junit5PluginAccessors(providers, config);
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);
        private final KotlinxPluginAccessors paccForKotlinxPluginAccessors = new KotlinxPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.jetbrains</b>
         */
        public JetbrainsPluginAccessors getJetbrains() {
            return paccForJetbrainsPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.junit5</b>
         */
        public Junit5PluginAccessors getJunit5() {
            return paccForJunit5PluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.kotlin</b>
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.kotlinx</b>
         */
        public KotlinxPluginAccessors getKotlinx() {
            return paccForKotlinxPluginAccessors;
        }

    }

    public static class JetbrainsPluginAccessors extends PluginFactory {
        private final JetbrainsComposePluginAccessors paccForJetbrainsComposePluginAccessors = new JetbrainsComposePluginAccessors(providers, config);

        public JetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.jetbrains.compose</b>
         */
        public JetbrainsComposePluginAccessors getCompose() {
            return paccForJetbrainsComposePluginAccessors;
        }

    }

    public static class JetbrainsComposePluginAccessors extends PluginFactory {

        public JetbrainsComposePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>jetbrains.compose.multiplatform</b> with plugin id <b>org.jetbrains.compose</b> and
         * with version reference <b>compose.multiplatform</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getMultiplatform() { return createPlugin("jetbrains.compose.multiplatform"); }

    }

    public static class Junit5PluginAccessors extends PluginFactory {

        public Junit5PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>junit5.android</b> with plugin id <b>de.mannodermaus.android-junit5</b> and
         * with version reference <b>junit5.plugin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAndroid() { return createPlugin("junit5.android"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>kotlin.compose</b> with plugin id <b>org.jetbrains.kotlin.plugin.compose</b> and
         * with version reference <b>kotlin.language</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getCompose() { return createPlugin("kotlin.compose"); }

        /**
         * Plugin provider for <b>kotlin.jvm</b> with plugin id <b>org.jetbrains.kotlin.jvm</b> and
         * with version reference <b>kotlin.language</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getJvm() { return createPlugin("kotlin.jvm"); }

        /**
         * Plugin provider for <b>kotlin.ksp</b> with plugin id <b>com.google.devtools.ksp</b> and
         * with version reference <b>kotlin.symbol.processing</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKsp() { return createPlugin("kotlin.ksp"); }

        /**
         * Plugin provider for <b>kotlin.parcelize</b> with plugin id <b>org.jetbrains.kotlin.plugin.parcelize</b> and
         * with version reference <b>kotlin.language</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getParcelize() { return createPlugin("kotlin.parcelize"); }

    }

    public static class KotlinxPluginAccessors extends PluginFactory {

        public KotlinxPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>kotlinx.atomicfu</b> with plugin id <b>org.jetbrains.kotlinx.atomicfu</b> and
         * with version reference <b>kotlinx.atomicfu</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAtomicfu() { return createPlugin("kotlinx.atomicfu"); }

        /**
         * Plugin provider for <b>kotlinx.serialization</b> with plugin id <b>org.jetbrains.kotlin.plugin.serialization</b> and
         * with version reference <b>kotlin.language</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getSerialization() { return createPlugin("kotlinx.serialization"); }

    }

}
