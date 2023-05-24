SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='fynesy/tdemo1/tdemo1-source')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='default')

k8s_custom_deploy(
    'tdemo1',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --yes >/dev/null" +
               " && kubectl get workload tdemo1 --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

allow_k8s_contexts('gke_sa-fynesy_us-east1-b_yugabytedb3')

k8s_resource('tdemo1', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'tdemo1'}])
allow_k8s_contexts('kind-ktap')
allow_k8s_contexts('akslab')
allow_k8s_contexts('akslab2')
